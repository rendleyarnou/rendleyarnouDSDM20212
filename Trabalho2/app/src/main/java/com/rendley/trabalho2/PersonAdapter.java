package com.rendley.trabalho2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.rendley.trabalho2.model.Person;

import java.util.ArrayList;

public class PersonAdapter extends ArrayAdapter<Person> {

    public PersonAdapter (@NonNull Context context, ArrayList<Person> people) {
        super(context, 0, people);
    }

    @Override
    public View getView (int position, View convertView, ViewGroup parent) {

        Person person = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_person_item, parent, false);
        }

        TextView tvId = convertView.findViewById(R.id.tvId);
        TextView tvName = convertView.findViewById(R.id.tvName);
        TextView tvCpf = convertView.findViewById(R.id.tvCpf);
        TextView tvEmail = convertView.findViewById(R.id.tvEmail);

        tvId.setText(person.getId());
        tvName.setText(person.getNome());
        tvCpf.setText(person.getCpf());
        tvEmail.setText(person.getEmail());

        return convertView;
    }

}

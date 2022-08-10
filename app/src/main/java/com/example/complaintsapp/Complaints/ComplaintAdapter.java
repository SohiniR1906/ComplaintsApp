package com.example.complaintsapp.Complaints;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.example.complaintsapp.R;

import java.util.ArrayList;

public class ComplaintAdapter extends ArrayAdapter<Complaint> {
    public ComplaintAdapter(Context context, ArrayList<Complaint> list) {
        super(context, 0, list);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.single_complaint_layout, parent, false);
        }
        Complaint complaint = getItem(position);
        TextView type = listItemView.findViewById(R.id.Hardware);
        type.setText(complaint.getType());
        TextView machine = listItemView.findViewById(R.id.Machine_id);
        machine.setText(complaint.getMachine());
        TextView description= listItemView.findViewById(R.id.Description);
        description.setText(complaint.getDescription());
        TextView email = listItemView.findViewById(R.id.Email_id);
        email.setText(complaint.getemail());
        TextView status=listItemView.findViewById(R.id.Status);
        status.setText(complaint.getStatus());
        if(complaint.getStatus().equals("COMPLETED")) {
            int color = ContextCompat.getColor(getContext(), R.color.green);
            status.setTextColor(color);
        }
        else if(complaint.getStatus().equals("PENDING"))
        {
            int color = ContextCompat.getColor(getContext(), R.color.red);
            status.setTextColor(color);
        }

        TextView complaint_id=listItemView.findViewById(R.id.id_complaint);
        complaint_id.setText(complaint.getID());
        return listItemView;
    }
}



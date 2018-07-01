package com.example.clair.ahbot;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MedProfileAdapter extends RecyclerView.Adapter<MedProfileAdapter.ViewHolder>{
    public List<MedicalProfile> medicalProfileList;
    Context context;


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName,tvAge,tvDiseases,tvAllergies;
        public ViewHolder(View itemView) {
            super(itemView);
            tvName=itemView.findViewById(R.id.tvName);
            tvAge=itemView.findViewById(R.id.tvAge);
            tvDiseases=itemView.findViewById(R.id.tvDiseases);
            tvAllergies=itemView.findViewById(R.id.tvAllergies);
        }
    }
    public MedProfileAdapter(Context context,List<MedicalProfile> medicalProfileList){
        this.context=context;
        this.medicalProfileList=medicalProfileList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.med_profile_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MedProfileAdapter.ViewHolder holder, int position) {
        final MedicalProfile medicalProfile=medicalProfileList.get(position);
        holder.tvName.setText(medicalProfile.getName());
        holder.tvAge.setText(medicalProfile.getAge());
        holder.tvDiseases.setText(medicalProfile.getDiseases());
        holder.tvAllergies.setText(medicalProfile.getAllergies());
    }

    @Override
    public int getItemCount() {
        return medicalProfileList==null?0:medicalProfileList.size();
    }

}

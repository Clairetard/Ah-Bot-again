package com.example.clair.ahbot;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MedicineAdapter  extends RecyclerView.Adapter<MedicineAdapter.ViewHolder>{
    public List<Medicine> medicineList;
    Context context;

    public MedicineAdapter(Context context){
        this.context=context;
        this.medicineList=new ArrayList<>();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tvMedName,tvDosage,tvFrequency,tvRemarks;
        public LinearLayout llRemarks;
        public ViewHolder(View itemView) {
            super(itemView);
            tvMedName=itemView.findViewById(R.id.tvMedName);
            tvDosage=itemView.findViewById(R.id.tvDosage);
            tvFrequency=itemView.findViewById(R.id.tvFrequency);
            tvRemarks=itemView.findViewById(R.id.tvRemarks);
            llRemarks=itemView.findViewById(R.id.llRemarks);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.med_profile_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Medicine medicine=medicineList.get(position);

        holder.tvMedName.setText(medicine.getMedName());
        holder.tvDosage.setText(medicine.getMedAmount());
        holder.tvDosage.setText(medicine.getMedFrequency());
        if(medicine.getRemarks()!=""){
            holder.tvRemarks.setText(medicine.getRemarks());
        }
        else {
            holder.llRemarks.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return medicineList==null?0:medicineList.size();
    }

    public void addItem(Medicine m){
        medicineList.add(m);
        notifyItemChanged(medicineList.size()-1);
    }
    public void addAlItems(List<Medicine> medicineList){
        for(Medicine medicine: medicineList){
            addItem(medicine);
        }
    }
    public void deleteEverything(){
        if(medicineList!=null) medicineList.clear();
    }
}

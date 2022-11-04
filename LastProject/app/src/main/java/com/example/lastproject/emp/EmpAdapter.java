package com.example.lastproject.emp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lastproject.MainActivity;
import com.example.lastproject.R;
import com.example.lastproject.customer.CusFragment;

import java.util.ArrayList;

public class EmpAdapter extends RecyclerView.Adapter<EmpAdapter.ViewHolder> {

    LayoutInflater inflater;
    ArrayList<EmployeeVO> list;

    public EmpAdapter(LayoutInflater inflater, ArrayList<EmployeeVO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_emp_recv, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        h.employee_id.setText(list.get(i).getEmployee_id()+"");
        h.name.setText(list.get(i).getName());
        h.department_id.setText(list.get(i).getDepartment_id()+"");
        h.job_title.setText(list.get(i).getJob_title());
        h.hire_date.setText(list.get(i).getHire_date()+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView employee_id, name, department_id, job_title, hire_date;
        Button btn_detail, btn_modify, btn_delete;
        public ViewHolder(@NonNull View v) {
            super(v);
            employee_id = v.findViewById(R.id.employee_id);
            name = v.findViewById(R.id.name);
            department_id = v.findViewById(R.id.department_id);
            job_title = v.findViewById(R.id.job_title);
            hire_date = v.findViewById(R.id.hire_date);
            btn_detail = v.findViewById(R.id.btn_detail);
            btn_modify = v.findViewById(R.id.btn_modify);
            btn_delete = v.findViewById(R.id.btn_delete);

        }
    }
}

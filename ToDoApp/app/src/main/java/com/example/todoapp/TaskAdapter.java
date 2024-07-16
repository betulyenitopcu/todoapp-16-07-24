package com.example.todoapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private List<Task> taskList;

    public TaskAdapter(List<Task> taskList) {
        this.taskList = taskList;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the item layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        // Bind data to UI elements
        Task task = taskList.get(position);
        holder.taskTextView.setText(task.getTaskText());
    }

    @Override
    public int getItemCount() {
        // Return the size of the task list
        return taskList.size();
    }

    public static class TaskViewHolder extends RecyclerView.ViewHolder {
        public TextView taskTextView;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            // Initialize UI elements
            taskTextView = itemView.findViewById(R.id.taskTextView);
        }
    }

    public void addTask(Task task) {
        // Add a new task to the list
        taskList.add(task);
        // Notify the adapter that the data set has changed
        notifyDataSetChanged();
    }
}

package com.company.chap25example;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.company.chap25example.databinding.CourseListItemBinding;
import com.company.chap25example.model.Course;

import java.util.ArrayList;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {
    private OnItemClickedListener listener;
    private ArrayList<Course> courses = new ArrayList<>();

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CourseListItemBinding courseListItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.course_list_item, parent, false);

        return new CourseViewHolder(courseListItemBinding);
    }
    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        Course course = courses.get(position);
        holder.courseListItemBinding.setCourse(course);
    }
    @Override
    public int getItemCount() {
        if (courses != null) {
            return courses.size();
        }
        return 0;
    }

    public class CourseViewHolder extends RecyclerView.ViewHolder {
        private CourseListItemBinding courseListItemBinding;

        public CourseViewHolder(CourseListItemBinding binding) {
            super(binding.getRoot());
            this.courseListItemBinding = binding;

            courseListItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int clickedPosition = getAdapterPosition();
                    if (listener != null && clickedPosition != RecyclerView.NO_POSITION) {
                        listener.onItemClick(courses.get(clickedPosition));
                    }
                }
            });
        }
    }

    public interface OnItemClickedListener {
        void onItemClick(Course course);
    }
    public void setListener(OnItemClickedListener listener) {
        this.listener = listener;
    }
    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
        notifyDataSetChanged();
    }
}

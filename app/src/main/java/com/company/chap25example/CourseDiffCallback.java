package com.company.chap25example;

import android.widget.ArrayAdapter;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

import com.company.chap25example.model.Course;

import java.util.ArrayList;

public class CourseDiffCallback extends DiffUtil.Callback {

    private ArrayList<Course> oldCourseList, newCourseList;

    public CourseDiffCallback(ArrayList<Course> oldCourseList, ArrayList<Course> newCourseList) {
        this.oldCourseList = oldCourseList;
        this.newCourseList = newCourseList;
    }

    @Override
    public int getOldListSize() {
        if (oldCourseList != null) {
            return oldCourseList.size();
        }
        return 0;
    }

    @Override
    public int getNewListSize() {
        if (newCourseList != null) {
            return newCourseList.size();
        }
        return 0;
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldCourseList.get(oldItemPosition).getCourseId()
                == newCourseList.get(newItemPosition).getCourseId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        // Since the equal() method compare the position in the memory rather than the value,
        // we need to override the equal() method in Course.java.
        return oldCourseList.get(oldItemPosition).equals(newCourseList.get(newItemPosition));
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }
}

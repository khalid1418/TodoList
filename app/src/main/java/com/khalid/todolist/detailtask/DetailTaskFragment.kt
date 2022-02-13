package com.khalid.todolist.detailtask

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.khalid.todolist.R
import com.khalid.todolist.TodoListApplication
import com.khalid.todolist.databinding.FragmentDetailTaskBinding
import com.khalid.todolist.databinding.FragmentTasksBinding
import com.khalid.todolist.mainpage.TasksViewModel
import com.khalid.todolist.utils.ViewModelFactory


class DetailTaskFragment : Fragment() {
    private var _binding: FragmentDetailTaskBinding? = null
    private val binding get() = _binding
    private val navArgument:DetailTaskFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentDetailTaskBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        alltask()
    }
    fun alltask(){
        binding?.taskDetailTitleText?.text = navArgument.title
        binding?.taskDetailDescriptionText?.text = navArgument.descriptio
        binding?.date?.text = navArgument.date
    }
}
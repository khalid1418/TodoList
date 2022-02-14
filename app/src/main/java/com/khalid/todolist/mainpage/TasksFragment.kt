package com.khalid.todolist.mainpage

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.khalid.todolist.R
import com.khalid.todolist.TodoListApplication
import com.khalid.todolist.databinding.FragmentTasksBinding
import com.khalid.todolist.utils.ViewModelFactory


class TasksFragment : Fragment() {
    private var _binding: FragmentTasksBinding? = null
    private val binding get() = _binding
    private val viewModel: TasksViewModel by activityViewModels {
        ViewModelFactory((activity?.application as TodoListApplication).repository)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTasksBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.addTaskFab?.setOnClickListener {
            val action = TasksFragmentDirections.actionTasksFragmentToAddTasksFragment()
            findNavController().navigate(action)
        }
        val adapter = TasksAdapter {
            val action = TasksFragmentDirections.actionTasksFragmentToDetailTaskFragment(
                it.title,
                it.description,
                it.datetask,
                it.id
            )
            findNavController().navigate(action)
        }
        binding?.recyclerView?.adapter = adapter
        viewModel.allTasksLiveData.observe(viewLifecycleOwner, {
            it.let {
                adapter.submitList(it)
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
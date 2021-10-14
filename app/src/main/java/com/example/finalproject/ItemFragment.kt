package com.example.finalproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.finalproject.databinding.FragmentItemListBinding
import com.example.finalproject.model.FoodEntity
import com.example.finalproject.model.FoodEntityItem
import com.example.finalproject.viewmodel.RecipeViewModel

/**
 * A fragment representing a list of Items.
 */
class ItemFragment : Fragment() {
    private lateinit var mRecipeViewModel: RecipeViewModel
    private lateinit var mBinding: FragmentItemListBinding
    private lateinit var mAdapter: MyItemRecyclerViewAdapter




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_item_list, container, false)

        // Set the adapter

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mRecipeViewModel = ViewModelProvider(this).get(RecipeViewModel::class.java)

    }
    private fun observeFilmItem(){
        mRecipeViewModel.recipe.observe(viewLifecycleOwner,{ response ->
            response?.let { responseNn->

                setFilms(responseNn)

            }

        })

    }

    private fun setFilms(responseNn: FoodEntity) {
        mBinding.rvList.layoutManager = LinearLayoutManager(context)
        mAdapter = MyItemRecyclerViewAdapter(responseNn)


    }


}
package com.tr4n.moviedb.presentation.ui.favorite

import com.bumptech.glide.Glide
import com.tr4n.moviedb.R
import com.tr4n.moviedb.base.BaseFragment
import com.tr4n.moviedb.base.recyclerview.SimpleBDAdapter
import com.tr4n.moviedb.databinding.FragmentFavoriteBinding
import com.tr4n.moviedb.databinding.ItemMovieBinding
import com.tr4n.moviedb.domain.model.Movie
import com.tr4n.moviedb.presentation.ui.detail.DetailFragmentArgs
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteFragment :
    BaseFragment<FragmentFavoriteBinding, FavoriteViewModel>(FragmentFavoriteBinding::inflate) {

    override val viewModel: FavoriteViewModel by viewModel()

    private val moviesAdapter by lazy {
        SimpleBDAdapter<ItemMovieBinding, Movie>(ItemMovieBinding::inflate) { itemBD, item, _ ->
            Glide.with(itemBD.imageMovie)
                .load(item.getFullPosterPath())
                .into(itemBD.imageMovie)
        }
    }

    override fun setupViews() {
        viewBD.recyclerFavoriteMovies.adapter = moviesAdapter.apply {
            onItemClick = { _, item, _ ->
                val bundle = DetailFragmentArgs(item.id).toBundle()
                navigate(R.id.detailFragment, bundle)
            }
        }
    }

    override fun initData() {
        viewModel.getFavoriteData()
    }

    override fun observeData() {
        viewModel.favoriteMovies.observe(viewLifecycleOwner) { movies ->
            moviesAdapter.submitList(movies)
        }
    }
}

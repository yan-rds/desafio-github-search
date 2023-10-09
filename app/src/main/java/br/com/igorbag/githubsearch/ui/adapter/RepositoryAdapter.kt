package br.com.igorbag.githubsearch.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.igorbag.githubsearch.R
import br.com.igorbag.githubsearch.domain.Repository

class RepositoryAdapter(
    private val repositories: List<Repository>,
    private val btnShareListener: (Repository) -> Unit = {}
) : RecyclerView.Adapter<RepositoryAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.repository_item, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentRepository = repositories[position]
        holder.bind(currentRepository, this)
        holder.nomeRepositorio.text = currentRepository.name
    }
    override fun getItemCount(): Int = repositories.size
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nomeRepositorio: TextView = view.findViewById(R.id.tv_repository_name)
        val btnShare: ImageView = view.findViewById(R.id.iv_share)
        fun bind(repository: Repository, adapter: RepositoryAdapter) {
            nomeRepositorio.text = repository.name
            btnShare.setOnClickListener {
                adapter.btnShareListener(repository)
            }
        }
    }
}



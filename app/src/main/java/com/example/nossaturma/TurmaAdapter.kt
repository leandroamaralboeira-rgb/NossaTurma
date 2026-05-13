package com.example.nossaturma

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * Adaptador para exibir a lista de alunos em um RecyclerView.
 */
class TurmaAdapter(
    private val listaAlunos: List<Aluno>,
    private val onClick: (Aluno) -> Unit // Função para tratar o clique
) : RecyclerView.Adapter<TurmaAdapter.AlunoViewHolder>() {

    // Define qual layout usar para cada item da lista (usaremos o padrão de lista simples do Android)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlunoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(android.R.layout.simple_list_item_1, parent, false)
        return AlunoViewHolder(view)
    }

    // Vincula os dados de um Aluno específico a um item da lista
    override fun onBindViewHolder(holder: AlunoViewHolder, position: Int) {
        holder.bind(listaAlunos[position], onClick)
    }

    override fun getItemCount(): Int = listaAlunos.size

    // Classe interna que controla os elementos visuais de cada item da lista
    class AlunoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Usamos o TextView padrão do layout 'simple_list_item_1'
        private val textViewNome = itemView.findViewById<TextView>(android.R.id.text1)

        fun bind(aluno: Aluno, onClick: (Aluno) -> Unit) {
            textViewNome.text = aluno.nome
            // Configura o clique no item inteiro
            itemView.setOnClickListener { onClick(aluno) }
        }
    }
}
package com.example.nossaturma

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TurmaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. Inicializar o RecyclerView
        recyclerView = findViewById(R.id.recyclerViewAlunos)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // 2. Criar a lista de 21 alunos (Para o envio inicial ao GitHub)
        // Substitua estes nomes pelos nomes reais da sua turma
        val alunosDaTurma = listOf(
            Aluno("João Silva"),
            Aluno("Maria Souza"),
            Aluno("Pedro Alves"),
            Aluno("Ana Lima"),
            Aluno("Carlos Santos"),
            // ... (até o 21º)
            Aluno("Professor - Exemplo")
        )

        // 3. Inicializar o Adapter, definindo o que acontece no clique
        adapter = TurmaAdapter(alunosDaTurma) { alunoSelecionado ->
            // No início, apenas mostra o nome. O código para abrir a tela individual
            // será adicionado na fase de integração final.
            Toast.makeText(this, "Selecionou: ${alunoSelecionado.nome}", Toast.LENGTH_SHORT).show()
        }

        // 4. Conectar o adapter ao RecyclerView
        recyclerView.adapter = adapter
    }
}
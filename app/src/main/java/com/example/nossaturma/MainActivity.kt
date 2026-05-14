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
            Aluno("Amanda"),
            Aluno("Anthony"),
            Aluno("Bruno"),
            Aluno("Daniel"),
            Aluno("David"),
            Aluno("Eduardo"),
            Aluno("Isadora"),
            Aluno("Jéssica"),
            Aluno("Júlia"),
            Aluno("Lorenzo"),
            Aluno("Manuella"),
            Aluno("Maria"),
            Aluno("Natasha"),
            Aluno("Paulo"),
            Aluno("Rafael"),
            Aluno("Sabrina"),
            Aluno("Samuel"),
            Aluno("Victor"),
            Aluno("Victor Hugo"),
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
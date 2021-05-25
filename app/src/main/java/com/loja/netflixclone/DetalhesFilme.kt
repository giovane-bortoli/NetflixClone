package com.loja.netflixclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.recyclerview.widget.GridLayoutManager
import com.loja.netflixclone.Adapter.FilmesAdapter
import com.loja.netflixclone.Model.addFilmes
import com.loja.netflixclone.databinding.ActivityDetalhesFilmeBinding
import com.squareup.picasso.Picasso

class DetalhesFilme : AppCompatActivity() {

    private lateinit var binding: ActivityDetalhesFilmeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalhesFilmeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()
        Toolbar()

        val recycler_outros_filmes = binding.recyclerOutrosFilmes
        recycler_outros_filmes.adapter = FilmesAdapter(addFilmes())
        recycler_outros_filmes.layoutManager = GridLayoutManager(applicationContext,3)

        val capaTheWitcher = "https://firebasestorage.googleapis.com/v0/b/netflixclonenew.appspot.com/o/video.jpg?alt=media&token=4d16ca03-71c6-46b6-8a30-cd0d29cb01b6"
        Picasso.get().load(capaTheWitcher).fit().into(binding.capa)

        binding.playVideo.setOnClickListener {
            val intent = Intent(this,Video::class.java)
            startActivity(intent)
        }
    }

    private fun Toolbar(){
        val toolbar_detalhes = binding.toolbarDetalhes
        toolbar_detalhes.setNavigationIcon(getDrawable(R.drawable.ic_voltar))
        toolbar_detalhes.setNavigationOnClickListener{
            val intent = Intent(this,ListaFilmes::class.java)
            startActivity(intent)
            finish()
        }

    }
}
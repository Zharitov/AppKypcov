package study.rtvx.finalstudyappkypcov

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class GameFragment : Fragment() {

    private lateinit var buttonGame: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_game, container, false)
        buttonGame = view.findViewById(R.id.start_game_button)
        buttonGame.setOnClickListener() {
            val intent = Intent(context, Game::class.java)
            startActivity(intent)
        }
        return view
    }
}
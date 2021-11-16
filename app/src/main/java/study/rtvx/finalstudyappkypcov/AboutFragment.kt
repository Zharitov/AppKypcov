package study.rtvx.finalstudyappkypcov

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class AboutFragment : Fragment() {

    private lateinit var linkTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val viewLink = inflater.inflate(R.layout.fragment_about, container, false)
        val address: Uri = Uri.parse("https://www.youtube.com/watch?v=OpVejPcAur4")
        linkTextView = viewLink.findViewById(R.id.link_text_view)
        linkTextView.setOnClickListener {
            val intent  = Intent (Intent.ACTION_VIEW,address)
            startActivity(intent)
        }
        return viewLink
    }
}
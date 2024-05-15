import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.example.srp.R

class fragment2 : Fragment() {

    private val completedTasks = mutableListOf<String>()
    private lateinit var linearLayout:LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_fragment2, container, false)
        val linearLayout=view.findViewById<View>(R.id.linearLayout)


        return view
    }

    }




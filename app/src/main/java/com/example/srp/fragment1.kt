import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.srp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

// Interface for checkbox state changes


class fragment1 : Fragment(){

    private lateinit var addButton: FloatingActionButton
    private lateinit var linearLayout: LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_fragment1, container, false)

        // Initialize views
        addButton = view.findViewById(R.id.floatingActionButton)
        linearLayout = view.findViewById(R.id.linearLayout)

        // Set click listener for the FloatingActionButton
        addButton.setOnClickListener {
            // Create a new CheckBox
            val input=EditText(requireContext())
            input.hint="Enter text for the task"
            AlertDialog.Builder(requireContext()).apply {
                setTitle("New CheckBox")
                setView(input)
                setPositiveButton("Add") { dialog, which ->
                    val checkBoxText = input.text.toString()
                    if (checkBoxText.isNotEmpty()) {
                        addNewCheckBox(checkBoxText)
                    }
                    else
                    {
                        Toast.makeText(requireContext(), "Cannot add empty task", Toast.LENGTH_SHORT).show()
                    }
                }
                setNegativeButton("Cancel") { dialog, which ->
                    dialog.cancel()
                }
                show()
            }

        }

        return view
    }
    private fun addNewCheckBox(text:String)
    {
        val newCheckBox=CheckBox(requireContext()).apply {
            this.text=text
            id=View.generateViewId()
        }
        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        ).apply {
            setMargins(16, 16, 16, 16) // Set margins
        }

        // Apply layout params to the CheckBox
        newCheckBox.layoutParams = params

        // Add the CheckBox to the LinearLayout
        linearLayout.addView(newCheckBox)
    }

}

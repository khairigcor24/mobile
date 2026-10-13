package com.example.mars_farhanalkhairi.pertemuan6

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.mars_farhanalkhairi.AuthActivity
import com.example.mars_farhanalkhairi.P2.SecondActivity
import com.example.mars_farhanalkhairi.databinding.FragmentHomeBinding
import com.example.mars_farhanalkhairi.pertemuan3.ThirdActivity
import com.example.mars_farhanalkhairi.pertemuan4.FourthActivity
import com.example.mars_farhanalkhairi.pertemuan5.FifthActivity

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)

        binding.btnP2.setOnClickListener {
            startActivity(Intent(requireContext(), SecondActivity::class.java))
        }

        binding.btnP3.setOnClickListener {
            startActivity(Intent(requireContext(), ThirdActivity::class.java))
        }

        binding.btnP4.setOnClickListener {
            val intent = Intent(requireContext(), FourthActivity::class.java).apply {
                putExtra("name", "Politeknik Caltex Riau")
                putExtra("from", "Rumbai")
                putExtra("age", 25)
            }
            startActivity(intent)
        }

        binding.btnP5.setOnClickListener {
            startActivity(Intent(requireContext(), FifthActivity::class.java))
        }

        binding.btnP6.setOnClickListener {
            startActivity(Intent(requireContext(), SixthActivity::class.java))
        }

        binding.btnLogout.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Konfirmasi Logout")
                .setMessage("Apakah Anda yakin ingin keluar?")
                .setPositiveButton("Ya") { _, _ ->
                    val sharedPreferences = requireContext().getSharedPreferences("user_pref", Context.MODE_PRIVATE)
                    sharedPreferences.edit().clear().apply()

                    val intent = Intent(requireContext(), AuthActivity::class.java)
                    startActivity(intent)
                    requireActivity().finish()
                }
                .setNegativeButton("Tidak") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

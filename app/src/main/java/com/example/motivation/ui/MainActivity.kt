package com.example.motivation.ui

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.motivation.R
import com.example.motivation.data.Mock
import com.example.motivation.databinding.ActivityMainBinding
import com.example.motivation.infra.MotivationConstants
import com.example.motivation.infra.SecurityPreferences
import java.util.Locale

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var categoryID = MotivationConstants.FILTER.ALL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handleUserName()
        handleFilter(R.id.image_all_inclusive)
        handleNextPhrase()

        // Events
        binding.buttonNewPhrase.setOnClickListener(this)
        binding.imageAllInclusive.setOnClickListener(this)
        binding.imageAutoAwesome.setOnClickListener(this)
        binding.imageAndroid.setOnClickListener(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_new_phrase) {
            handleNextPhrase()
        } else if (view.id in listOf(
                R.id.image_all_inclusive,
                R.id.image_auto_awesome,
                R.id.image_android
            )
        ) {
            handleFilter(view.id)
        }
    }

    private fun handleNextPhrase() {
        binding.textPhrase.text = Mock().getPhrase(categoryID, Locale.getDefault().language)
    }

    private fun handleFilter(id: Int) {
        binding.imageAllInclusive.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageAutoAwesome.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageAndroid.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))

        when (id) {
            R.id.image_all_inclusive -> {
                binding.imageAllInclusive.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryID = MotivationConstants.FILTER.ALL
            }
            R.id.image_auto_awesome -> {
                binding.imageAutoAwesome.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryID = MotivationConstants.FILTER.AUTO
            }
            R.id.image_android -> {
                binding.imageAndroid.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryID = MotivationConstants.FILTER.ANDROID
            }
        }
    }


    private fun handleUserName() {
        val name = SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)
        binding.textUserName.text = "${getString(R.string.hello)}, $name!"
    }

}
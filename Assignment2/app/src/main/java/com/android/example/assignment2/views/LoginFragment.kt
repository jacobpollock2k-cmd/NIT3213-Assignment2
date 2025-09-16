package com.android.example.assignment2.views

import android.net.http.HttpResponseCache
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.android.example.assignment2.R
import com.android.example.assignment2.models.User
import com.android.example.assignment2.viewmodels.ApiViewModel
import com.google.android.material.button.MaterialButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Response


@AndroidEntryPoint
class LoginFragment : Fragment() {

    private val viewModel: ApiViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val loginButton = view.findViewById<MaterialButton>(R.id.btnLogin)


        loginButton.setOnClickListener {
            var usernameText = view.findViewById<TextInputEditText>(R.id.usernameTextField).text.toString()
            var passwordText = view.findViewById<TextInputEditText>(R.id.passwordTextField).text.toString()

            var user = User(passwordText, usernameText)
            Log.d("LoginFragment", "Username: ${usernameText}, Password:${passwordText}")

            viewModel.authoriseUser(user)

            lifecycleScope.launch {
                viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {

                    viewModel.objectState.collect { itemsInApiResponse ->
                        Log.d("LoginFragment", "${findNavController().currentDestination}")
                        Log.d("LoginFragment", "KeyPass: ${itemsInApiResponse.keypass}")
                        delay(1000)
                        if (itemsInApiResponse.keypass.isNotEmpty()){
                            val action = LoginFragmentDirections.actionLoginFragmentToDashboardFragment(itemsInApiResponse)
                            delay(300)
                            findNavController().navigate(action)
                            Snackbar.make(view, "Login Success", Snackbar.LENGTH_SHORT).show()
                        }else{
                            Snackbar.make(view, "Login Error", Snackbar.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }




    }



}
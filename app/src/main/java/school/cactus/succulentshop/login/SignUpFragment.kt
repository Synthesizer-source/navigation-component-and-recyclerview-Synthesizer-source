package school.cactus.succulentshop.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import school.cactus.succulentshop.EmailValidator
import school.cactus.succulentshop.PasswordValidator
import school.cactus.succulentshop.R
import school.cactus.succulentshop.UsernameValidator
import school.cactus.succulentshop.databinding.FragmentSignUpBinding
import school.cactus.succulentshop.utils.validate

class SignUpFragment : Fragment() {
    private lateinit var binding: FragmentSignUpBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignUpBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {

            textInputLayoutEmail.editText!!.setText("abcd@gmail.com")
            textInputLayoutUsername.editText!!.setText("hasan")
            textInputLayoutSignUpPassword.editText!!.setText("Hasan_01")

            buttonAlreadyHaveAccount.setOnClickListener {
                navigateToLogin()
            }

            buttonSignUp.setOnClickListener {
                textInputLayoutEmail.validate(EmailValidator())
                textInputLayoutUsername.validate(UsernameValidator())
                textInputLayoutSignUpPassword.validate(PasswordValidator())
                success()

            }
        }
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = FragmentSignUpBinding.inflate(layoutInflater)
////        setContentView(binding.root)
////        supportActionBar?.title = resources.getString(R.string.sign_up)
//
//        binding.apply {
//            buttonAlreadyHaveAccount.setOnClickListener {
//                navigateToLogin()
//            }
//
//            buttonSignUp.setOnClickListener {
//                textInputLayoutEmail.validate(EmailValidator())
//                textInputLayoutUsername.validate(UsernameValidator())
//                textInputLayoutSignUpPassword.validate(PasswordValidator())
//            }
//        }
//
//
//    }

    private fun navigateToLogin() {
//        val intent = Intent(this, LoginActivity::class.java)
//        startActivity(intent)
//        finish()
        val action = SignUpFragmentDirections.login()
        findNavController().navigate(action)
    }

    private fun success(){
        val action = SignUpFragmentDirections.signUpSuccess()
        findNavController().navigate(action)
    }
}
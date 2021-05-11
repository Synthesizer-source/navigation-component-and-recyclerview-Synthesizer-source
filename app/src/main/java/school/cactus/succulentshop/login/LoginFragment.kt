package school.cactus.succulentshop.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import school.cactus.succulentshop.login.validation.IdentifierValidator
import school.cactus.succulentshop.PasswordValidator
import school.cactus.succulentshop.databinding.FragmentLoginBinding
import school.cactus.succulentshop.utils.validate

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {

            identifierInputLayout.editText!!.setText("hasan")
            passwordInputLayout.editText!!.setText("Hasan_01")


            createAccountButton.setOnClickListener {
                navigateToSignUp()
            }

            logInButton.setOnClickListener {
                identifierInputLayout.validate(IdentifierValidator())
                passwordInputLayout.validate(PasswordValidator())
                val action = LoginFragmentDirections.loginSuccessful()
                findNavController().navigate(action)
            }
        }
    }
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        _binding = FragmentLoginBinding.inflate(layoutInflater)
//
////        setContentView(binding.root)
////        supportActionBar?.title = resources.getString(R.string.log_in)
//
//        binding.apply {
//            createAccountButton.setOnClickListener {
//                navigateToSignUp()
//            }
//
//            logInButton.setOnClickListener {
//                identifierInputLayout.validate(IdentifierValidator())
//                passwordInputLayout.validate(PasswordValidator())
//            }
//        }
//    }

    private fun navigateToSignUp() {
//        val intent = Intent(this, SignUpActivity::class.java)
//        startActivity(intent)
//        finish()

        val action = LoginFragmentDirections.createAccount()
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
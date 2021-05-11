package school.cactus.succulentshop.product.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import school.cactus.succulentshop.R
import school.cactus.succulentshop.databinding.FragmentProductDetailBinding
import school.cactus.succulentshop.product.BUNDLE_KEY_PRODUCT_ID
import school.cactus.succulentshop.product.list.ProductStore

class ProductDetailFragment : Fragment() {
    private var _binding: FragmentProductDetailBinding? = null

    private val binding get() = _binding!!

    private val store = ProductStore()

    private val adapter = RelatedProductAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().title = getString(R.string.app_name)

        savedInstanceState?.let {
            val pos = it.getIntArray("SCROLL_POSITION")
            binding.productDetailScrollView.apply {
                post {
                    this.scrollTo(pos!![0], pos[1])
                }
            }
        }

        val productId = requireArguments().getInt(BUNDLE_KEY_PRODUCT_ID)
        val product = store.findProduct(productId)
        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        adapter.itemClickListener = {
            val action = ProductDetailFragmentDirections.openRelatedProduct(it.id)
            findNavController().navigate(action)
        }

        binding.apply {
            relatedProductsRecyclerView.layoutManager = layoutManager
            relatedProductsRecyclerView.adapter = adapter.apply {
                submitList(store.relatedProducts(productId))
            }
            relatedProductsRecyclerView.addItemDecoration(RelatedProductDecoration())
            imageView.setImageResource(product.imageUrl)
            titleText.text = product.title
            priceText.text = product.price
            descriptionText.text = product.description

        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putIntArray("SCROLL_POSITION",
            intArrayOf(binding.productDetailScrollView.scrollX, binding.productDetailScrollView.scrollY));
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}
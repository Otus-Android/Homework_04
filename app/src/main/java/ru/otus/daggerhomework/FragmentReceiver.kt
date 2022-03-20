package ru.otus.daggerhomework

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import io.reactivex.rxjava3.subjects.PublishSubject
import ru.otus.daggerhomework.viewmodels.ViewModelFactory
import ru.otus.daggerhomework.viewmodels.injectViewModel
import javax.inject.Inject

class FragmentReceiver @Inject constructor() : Fragment() {

    private lateinit var frame: View

    @Inject
    protected lateinit  var application: Application

    @Inject
    protected lateinit var publishSubject: PublishSubject<Int>

    @Inject
    protected lateinit var viewModelFactory: ViewModelFactory

    protected lateinit var viewModel : ViewModelReceiver

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = injectViewModel(viewModelFactory)
        frame = view.findViewById(R.id.frame)

        viewModel.result.observe(viewLifecycleOwner, { it ->
            if (it is ViewModelReceiver.Result.Success) {
                this.populateColor(it.color)
            }
        })

        viewModel.observeColors()
    }

    fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
    }
}
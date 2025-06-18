package pt.ipg.diariodehumor

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pt.ipg.diariodehumor.data.MoodDatabase
import pt.ipg.diariodehumor.data.MoodEntry

class MoodViewModel(application: Application) : AndroidViewModel(application) {

    private val moodDao = MoodDatabase.getDatabase(application).moodDao()

    var lista = emptyList<MoodEntry>()
        private set

    fun carregarDados() {
        viewModelScope.launch {
            lista = moodDao.listarTodos()
        }
    }

    fun adicionar(moodEntry: MoodEntry) {
        viewModelScope.launch(Dispatchers.IO) {
            moodDao.inserir(moodEntry)
            carregarDados()
        }
    }

    fun apagar(moodEntry: MoodEntry) {
        viewModelScope.launch(Dispatchers.IO) {
            moodDao.apagar(moodEntry)
            carregarDados()
        }
    }
}

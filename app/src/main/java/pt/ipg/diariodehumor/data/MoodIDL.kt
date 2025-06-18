
package pt.ipg.diariodehumor.data
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Delete
import androidx.room.Query

interface MoodIDL {

    @Insert
    suspend fun  inserir(moodEntry: MoodEntry)

    @Delete
    suspend fun apagar(moodEntry: MoodEntry)

    @Query ("SELECT * FROM MoodEntry ORDER BY date DESC")
    suspend fun  listarTodos(): List<MoodEntry>

}
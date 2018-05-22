package com.example.mast.animemangareminder

import com.example.mast.animemangareminder.Repository.AnimeRepo
import org.junit.Before
import org.junit.Test
import org.junit.Assert.*
import org.mockito.Mockito.*


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class AnimePresenterTest {
    var view = mock(AnimeView :: class.java)
    var repo = mock(AnimeRepo :: class.java)
    var presenter = AnimePresenter(view, repo)
    var inOrder = inOrder(repo)
    var inOrder2 = inOrder(view)

    @Before
    fun init(){
        view = mock(AnimeView :: class.java)
        repo = mock(AnimeRepo :: class.java)
        presenter = AnimePresenter(view, repo)
        inOrder = inOrder(repo)
        inOrder2 = inOrder(view)
    }

    @Test
    fun testStart() {
        presenter.start()
        inOrder.verify(repo).addObserver(presenter)

    }

    @Test
    fun testUpdate(){
        presenter.update(repo, null)
        inOrder2.verify(view).notifyAnime(presenter.toString())
    }


}

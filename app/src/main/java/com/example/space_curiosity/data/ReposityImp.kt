package com.example.space_curiosity.data

import com.example.space_curiosity.di.moduleApiNasa
import javax.inject.Inject

class ReposityImp @Inject constructor()  {

     suspend fun getResponse(): responseNasa {
        return moduleApiNasa.getCall()
    }


}
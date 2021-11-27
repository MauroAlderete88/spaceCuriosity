package com.example.space_curiosity.domain

import com.example.space_curiosity.data.ReposityImp
import com.example.space_curiosity.data.responseNasa
import javax.inject.Inject

class useCaseMainActivity @Inject constructor(
    val ReposityImp : ReposityImp
) {

   suspend fun queryService () : responseNasa {
      return ReposityImp.getResponse()
   }


}
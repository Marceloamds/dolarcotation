package br.com.dollar.presentation.util.placeholder.types

import br.com.dollar.presentation.util.placeholder.Placeholder

class Loading(val message: String? = null) : Placeholder {
    override val progressVisible: Boolean get() = true
    override val visible: Boolean get() = true
    override val buttonVisible: Boolean get() = false
    override val messageVisible: Boolean get() = message != null
}
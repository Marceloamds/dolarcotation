package br.com.dollar.presentation.util.placeholder.types

import br.com.dollar.presentation.util.placeholder.Placeholder

class Hide : Placeholder {
    override val progressVisible: Boolean get() = false
    override val visible: Boolean get() = false
    override val buttonVisible: Boolean get() = false
    override val messageVisible: Boolean get() = false
}
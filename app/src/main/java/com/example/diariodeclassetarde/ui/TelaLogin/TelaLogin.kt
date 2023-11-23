package com.example.diariodeclassetarde.ui.TelaLogin

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.diariodeclassetarde.R


@Preview(showSystemUi = true)
@Composable
fun TelaLogin(
    espacoDasBarras:PaddingValues
) {
    var nome by remember { mutableStateOf("") }
    var login by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var confirmarSenha by remember { mutableStateOf("") }
    var cadastrar by remember { mutableStateOf(false) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(espacoDasBarras)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(15.dp),
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessVeryLow
                    )
                )
        ) {
            if (cadastrar) {
                CampoDeTexto(
                    value = nome,
                    onValueChange = { nome = it },
                    idtexto = R.string.nome
                )
            }
            CampoDeTexto(
                value = login,
                onValueChange = { login = it },
                idtexto = R.string.login
            )
            CampoDeTexto(
                value = senha,
                onValueChange = { senha = it },
                idtexto = R.string.senha
            )
            if (cadastrar) {
                CampoDeTexto(
                    value = confirmarSenha,
                    onValueChange = { confirmarSenha = it },
                    idtexto = R.string.confirmarSenha
                )
            }
        }
        if (!cadastrar) {
            Text(
                text = "Cadastrar",
                modifier = Modifier.clickable {
                    cadastrar = true
                }
            )
        }
        Spacer(modifier = Modifier.size(10.dp))
        Button(
            onClick = {
                cadastrar = false
            }
        ) {
            Text(
                text = if (cadastrar)
                    "Cadastrar"
                else
                    "Entrar"
            )
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CampoDeTexto(
    value: String,
    onValueChange: (String) -> Unit,
    idtexto: Int
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(
                text = stringResource(idtexto)
            )
        }
    )
}
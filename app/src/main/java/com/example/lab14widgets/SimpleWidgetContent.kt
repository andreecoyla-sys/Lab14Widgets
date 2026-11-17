package com.example.lab14widgets

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.Button
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.GlanceTheme
import androidx.glance.action.actionStartActivity
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.cornerRadius
import androidx.glance.appwidget.provideContent
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.Spacer
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.fillMaxWidth
import androidx.glance.layout.height
import androidx.glance.layout.padding
import androidx.glance.layout.width
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextStyle

class SimpleWidgetContent : GlanceAppWidget() {

    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            GlanceTheme {
                ProjectDashboardWidget()
            }
        }
    }

    @Composable
    private fun ProjectDashboardWidget() {
        Column(
            modifier = GlanceModifier
                .fillMaxSize()
                .background(GlanceTheme.colors.surface)
                .cornerRadius(16.dp)
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalAlignment = Alignment.Start
        ) {
            // Encabezado con jerarquía clara (Android UI Kit)
            Text(
                text = "Mi Proyecto • Resumen",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = GlanceTheme.colors.onSurface
                )
            )

            Spacer(modifier = GlanceModifier.height(6.dp))

            // Tarjeta interna con información de estado / últimas acciones
            Column(
                modifier = GlanceModifier
                    .fillMaxWidth()
                    .background(GlanceTheme.colors.secondaryContainer)
                    .cornerRadius(12.dp)
                    .padding(10.dp)
            ) {
                Text(
                    text = "• 3 tareas pendientes hoy",
                    style = TextStyle(
                        fontSize = 13.sp,
                        color = GlanceTheme.colors.onSecondaryContainer
                    )
                )
                Text(
                    text = "• Última acción: Sincronizado",
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = GlanceTheme.colors.onSecondaryContainer
                    )
                )
            }

            Spacer(modifier = GlanceModifier.height(10.dp))

            // Fila de accesos directos a funciones de la app
            Row(
                modifier = GlanceModifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    text = "Inicio",
                    onClick = actionStartActivity<MainActivity>(),
                    modifier = GlanceModifier.defaultWeight()
                )
                Spacer(modifier = GlanceModifier.width(8.dp))
                Button(
                    text = "Tareas",
                    onClick = actionStartActivity<WorkActivity>(),
                    modifier = GlanceModifier.defaultWeight()
                )
            }
        }
    }
}
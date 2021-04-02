package com.example.androiddevchallenge.data

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.gray700
import com.example.androiddevchallenge.ui.theme.green
import com.example.androiddevchallenge.ui.theme.red
import com.example.androiddevchallenge.ui.theme.typography

// TODO this naming hurts readability

@Composable
fun StockPositionsList(positions: List<StockPositionDO>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.surface)
            .padding(16.dp),
    ) {
        Text(
            text = "Positions",
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(24.dp))
        LazyColumn {
            items(positions) { position ->
                Spacer(
                    modifier = Modifier
                        .height(1.dp)
                        .background(color = gray700)
                )
                StockPosition(position)
            }
        }
    }
}

@Composable
fun StockPosition(position: StockPositionDO) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
    ) {
        Column {
            Text(
                text = position.value,
                style = typography.body1,
                modifier = Modifier.paddingFromBaseline(24.dp)
            )
            Text(
                text = position.percentChange,
                style = typography.body1,
                color = if (position.percentChange.startsWith('-')) red else green,
                modifier = Modifier.paddingFromBaseline(16.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
        Column(modifier = Modifier.padding(start = 64.dp)) {
            Text(
                text = position.acronym,
                style = typography.h3,
                modifier = Modifier.paddingFromBaseline(24.dp)
            )
            Text(
                text = position.name,
                style = typography.body1,
                modifier = Modifier.paddingFromBaseline(16.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
        // TODO figure out how to end align Image so I can remove the box
        Box(modifier = Modifier.weight(1f)){}
        Image(
            painter = painterResource(id = position.chartGraph),
            contentDescription = "",
            modifier = Modifier.align(Alignment.CenterVertically),
            contentScale = ContentScale.FillHeight,
        )
    }
}

@Preview
@Composable
fun StockPositionsListPreview() {
    StockPositionsList(StockPositionsDataHelper.getStockPositions())
}

@Preview
@Composable
fun StockPositionPreview() {
    StockPosition(StockPositionsDataHelper.getStockPosition())
}

data class StockPositionDO(
    val acronym: String,
    val name: String,
    val value: String,
    val percentChange: String,
    val chartGraph: Int,
)

class StockPositionsDataHelper {
    companion object{

        /**
         * Helper method used for getting fake data of multiple positions position
         */
        fun getStockPositions(): List<StockPositionDO> {
            return listOf<StockPositionDO>(
                StockPositionDO("ALK", "Alaska Air Group, Inc", "$7,918", "-0.54%", R.drawable.home_alk),
                StockPositionDO("BA", "Boeing Co.", "$1,293", "+4.18%", R.drawable.home_ba),
                StockPositionDO("DAL", "Delta Airlines Inc.", "$893.50", "-0.54%", R.drawable.home_dal),
                StockPositionDO("EXPE", "Expedia Group Inc.", "$12,301", "+2.51%", R.drawable.home_exp),
                StockPositionDO("EADSY", "Airbus SE", "$12,301", "+1.38%", R.drawable.home_eadsy),
                StockPositionDO("JBLU", "JEtblue Airways Corp.", "$8,251", "+1.56%", R.drawable.home_jblu),
                StockPositionDO("MAR", "Marriot International Inc.", "$521", "+2.75%", R.drawable.home_mar),
                StockPositionDO("CCL", "Carnival Corp", "$5,481", "+0.14%", R.drawable.home_ccl),
                StockPositionDO("RCL", "Royal Caribbean Cruises", "$9,184", "+1.69%", R.drawable.home_rcl),
                StockPositionDO("TRVL", "Travelocity Inc.", "$654", "+3.23%", R.drawable.home_trvl),
            )
        }

        /**
         * Helper method used for getting fake data of single position
         */
        fun getStockPosition(): StockPositionDO {
            return StockPositionDO("Alk", "Alaska Air Group, Inc.", "$7,918", "-0.54%", R.drawable.home_alk)
        }
    }
}
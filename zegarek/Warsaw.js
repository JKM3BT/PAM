import {Text, View, StyleSheet} from 'react-native';
import {useState, useEffect} from 'react';
import moment from 'moment';
export default function ShowTime(){
    const currentDate = moment().format('Do MMMM YYYY')
    const currentTime = moment().format('h:mm a')
    const [Date, setDate] = useState(currentDate)
    return(
      <View style={{flex:1,justifyContent: 'flex-end'}}>
        <Text style={{fontSize:20}}>{currentDate}</Text>
        <Text style={{fontSize:40}}>{currentTime}</Text>
      </View>
    )
}
setInterval(ShowTime, 1000)
import {View, Text, Button} from 'react-native';
import {useEffect, useState} from 'react';
const UseEffectComponent = () => {

  const [counter,setCounter] = useState(0)

  const funkcjaCzyszczaca = () => console.log("Komponent Odmontowany")

  const funkcjaWywolanaWuseEffect = () =>{
    console.log(`Komponent został zamontowany ${counter}`)
    return funkcjaCzyszczaca();
  }

  useEffect(funkcjaWywolanaWuseEffect, [counter])

  return(
    <View>
      <Text>licznik {counter}</Text>
      <Button onPress={()=>setCounter(counter + 1)} title="wywołaj hooka useEffect()"/>
    </View>
  )
}
export default UseEffectComponent;
import {StyleSheet, View } from 'react-native';
import {Button} from 'react-native-paper';
import ShowTime from './Warsaw';
export default function App() {
  return (
  <View style={styles.container}>
    <Button mode="elevated" icon="arrow-left"/>
    <ShowTime/>
    <Button mode='elevated' icon='arrow-right'/>
  </View>
  );
}

const styles = StyleSheet.create({
  container: {
    display: 'flex',
    flexDirection: 'row',
    justifyContent: 'space-between',
    marginTop: '100%',
  },
});

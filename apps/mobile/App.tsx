import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import { StatusBar } from 'expo-status-bar';
import { useState } from 'react';
import { FlatList, StyleSheet, Text, TouchableHighlight, View } from 'react-native';

const names = ['Wocester', 'Franklin', 'Hampsire', 'Berkshire']

type HallButtonProps = {
  hall: string
}

type EventButtonProps = {
  color: string
}

function HallButton({ hall }: HallButtonProps) {
  const [isPressed, setPressed] = useState(false)
  return (
    <TouchableHighlight
      onPress={() => setPressed(!isPressed)}
      style={(isPressed) ? styles.hallButtonPressed : styles.hallButton}
    >
      <Text
        style={(isPressed) ? { color: 'white', marginTop: 30, textAlign: 'center' } : { color: 'black', marginTop: 30, textAlign: 'center' }}
      >
        {hall}
      </Text>
    </TouchableHighlight>
  )
}

function EventButton({ color }: EventButtonProps) {
  return (
    <TouchableHighlight
      style={{ backgroundColor: color, borderWidth: 2, borderRadius: 25, width: 200 }}
    >
      <Text
        style={{ color: 'black', margin: 30, textAlign: 'center' }}
      >
        Event
      </Text>
    </TouchableHighlight>
  )
}

// TODO: Add an Icon
function ViewButton() {
  return (
    <TouchableHighlight
      style={{ backgroundColor: 'green', borderWidth: 2, borderRadius: 25, width: 100 }}
    >
      <Text
        style={{ color: 'black', margin: 30, textAlign: 'center' }}
      >
        View
      </Text>
    </TouchableHighlight>
  )
}

function AddButton() {
  return (
    <TouchableHighlight
      style={{ backgroundColor: 'red', borderWidth: 2, borderRadius: 25, width: 100 }}
    >
      <Text
        style={{ color: 'black', margin: 30, textAlign: 'center' }}
      >
        +
      </Text>
    </TouchableHighlight>
  )
}

function HomeScreen() {
  return (
    <View style={styles.container}>
      <Text style={{ fontSize: 56 }}> App Title</Text>
      <Text
        style={{ fontSize: 28, fontWeight: 'bold' }}>
        Halls
      </Text>
      <FlatList
        data={names}
        style={{ flexGrow: 0 }}
        numColumns={2}
        renderItem={({ item }) =>
          <HallButton hall={item} />
        }
      />
      <StatusBar style="auto" />
    </View>
  )
}

// TODO: Add Route Parameters for Dining Hall
// NOTE: Do we use SWR or another fetch?
function EventScreen() {
  return (
    <View style={styles.container}>
      <Text style={{ fontSize: 56 }}> X Hall </Text>
      <EventButton color='yellow' />
      <View
        style={{ flexDirection: 'row', gap: 4 }}
      >
        <ViewButton />
        <AddButton />
      </View>
    </View>
  )
}

const Stack = createNativeStackNavigator()

// TODO: Add Links
export default function App() {
  return (
    <NavigationContainer>
      <Stack.Navigator initialRouteName='Event'>
        <Stack.Screen name='Event' component={EventScreen} />
        <Stack.Screen name='Home' component={HomeScreen} />
      </Stack.Navigator>
    </NavigationContainer>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    gap: 8,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
  hallButton: {
    backgroundColor: 'white',
    padding: 10,
    borderColor: 'black',
    borderWidth: 2,
    borderRadius: 20,
    width: 100,
    height: 100,
    margin: 10
  },
  hallButtonPressed: {
    backgroundColor: 'black',
    padding: 10,
    borderColor: 'white',
    color: 'white',
    borderWidth: 2,
    borderRadius: 20,
    width: 100,
    height: 100,
    margin: 10
  }

});

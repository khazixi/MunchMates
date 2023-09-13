import { NavigationContainer, NavigationContext } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import { StatusBar } from 'expo-status-bar';
import { useState } from 'react';
import { FlatList, StyleSheet, Text, TouchableHighlight, View } from 'react-native';

const names = ['Wocester', 'Franklin', 'Hampsire', 'Berkshire']

type HallButtonProps = {
  hall: string
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

// TODO: This needs a route parameter
function EventScreen() {
  return (
    <View>
      <Text> Events </Text>
    </View>
  )
}

const Stack = createNativeStackNavigator()

export default function App() {
  return (
    <NavigationContainer>
      <Stack.Navigator initialRouteName='Home'>
        <Stack.Screen name='Home' component={HomeScreen} />
        <Stack.Screen name='Event' component={EventScreen} />
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

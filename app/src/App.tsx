import React, {ChangeEvent, useEffect, useState} from 'react';

const App: React.FC = () => {
    let initialState = {navn:'',
        beskrivelse: ''};
    const [rom, doHydrate] = useState(initialState);
    const [input, userInput] = useState("");

    useEffect(() => {
        fetchData();
    }, []);

    const fetchData = async () => {
        await fetch("/start")
            .then((response) => response.json())
            .then(data => {
                doHydrate(data)
            })
            .catch(error => {
                console.log(error)
            })
    }

    const onUserInput = (event: ChangeEvent<HTMLInputElement>) => {
        userInput(event.target.value);
    }

    const movePlayer = () => {
        console.log(input)
        fetch("/svar/" + input)
            .then((response) => response.json())
            .then(data => {
                doHydrate(data)
            })
            .catch(error => {
                console.log(error)
            })
    }

    return (
    <div>
      <h1>Et solid eventyr!</h1>

        <h2>{rom.navn}</h2>
        <p>{rom.beskrivelse}</p>

        <div>
            <input
                type="text"
                name="payloadBox"
                placeholder="Hva vil du gjøre"
                value={ input }
                onChange={ onUserInput }
            />
            <input type="submit" value="Svar" onClick={() => movePlayer()} />
        </div>

    </div>
  );
}

export default App;

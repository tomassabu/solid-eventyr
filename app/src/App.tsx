import React, {ChangeEvent, useEffect, useState} from 'react';

const App: React.FC = () => {

    let rom = {navn:'',
        beskrivelse: ''};

    let initialState = {rom: rom, advarsel: ''};
    const [spillerObjekt, doHydrate] = useState(initialState);
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

        <h2>{spillerObjekt.rom.navn}</h2>
        <p>{spillerObjekt.rom.beskrivelse}</p>

        <p>{spillerObjekt.advarsel}</p>
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

import React, { useState } from 'react';

function CurrencyConverter() {
  const [rupees, setRupees] = useState();
  const [currency, setCurrency] = useState('');

  const rates = {
    USD: 85,
    EURO: 90,
    JPY: 0.75,
    AUD: 60,
  };

  const handleConvert = () => {
    if (!rupees || !currency) {
      alert('Please enter both amount and currency code!');
      return;
    }

    const rate = rates[currency.toUpperCase()];
    if (rate) {
      alert("Converting "+ currency.toUpperCase()+":"+(Number(rupees) * rate).toFixed(2));
    } else {
      alert('Currency not supported!');
    }
  };

  return (
    <div>
      <h2>Currency Converter!!!</h2>
      <h3>Amount:</h3>
      <input
        type="number"
        placeholder="Amount"
        value={rupees}
        onChange={e => setRupees(e.target.value)}
      />
      <h3>Currency:</h3>
      <input
        type="text"
        placeholder="Currency code (e.g. USD)"
        value={currency}
        onChange={e => setCurrency(e.target.value)}
        style={{ textTransform: 'uppercase', marginLeft: '10px' }}
      />
      <button onClick={handleConvert} style={{ marginLeft: '10px' }}>
        Submit
      </button>
    </div>
  );
}

export default CurrencyConverter;

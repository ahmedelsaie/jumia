import axios from 'axios';
import { useEffect, useState } from 'react';

const useCountries = () => {
  const [loading, setLoading] = useState(false);
  const [data, setData] = useState([]);
  useEffect(() => {
    setLoading(true);
    axios
      .get('http://localhost:5897/countries')
      .then(res => {
        setData(res.data);
        setLoading(false);
      })
      .catch(err => {
        console.log(err);
        setLoading(false);
      })
  }, [setLoading]);

  return {
    loading,
    countries: data
  };
};

export default useCountries;
import axios from 'axios';
import { useEffect, useState } from 'react';

const useStates = () => {
  const [loading, setLoading] = useState(false);
  const [data, setData] = useState([]);
  useEffect(() => {
    setLoading(true);
    axios
      .get('http://localhost:5897/states')
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
    states: data
  };
};

export default useStates;
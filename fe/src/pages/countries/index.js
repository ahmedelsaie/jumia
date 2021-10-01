import { useState } from 'react';
import useCountries from '../../api/countries';
import useStates from '../../api/states';
import Filter from './Filter';
import List from './List';

const Countries = () => {
  const { countries, loading: loadingCountries } = useCountries();
  const { states, loading: loadingStates } = useStates();
  const [search, setSearch] = useState(null);

  return loadingCountries || loadingStates ?
    <p>Loading...</p>
  : (
      <>
        <Filter
          countries={countries}
          states={states}
          setSearch={setSearch}
        />
        <List search={search} />
      </>
    );
};
export default Countries;
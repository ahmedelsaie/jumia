import React from 'react';
import { useForm, Controller } from 'react-hook-form';
import Select from 'react-select';

const mapCountriesToOptions = (array) => {
  return array.map(x => {
    return {
      value: x.code,
      label: x.name
    }
  });
}
const mapStates = (array) => {
  return array.map(x => {
    return {
      value: x,
      label: x
    }
  })
}
const Filter = ({ countries, states, setSearch }) => {
  const { control, errors, handleSubmit } = useForm();
  const onSubmit = data => {
    console.log(data);
    setSearch({
      country: data?.country?.value,
      state: data?.state?.value
    });
  }

  return (
    <form onSubmit={handleSubmit(onSubmit)}>
      <Controller
        control={control}
        defaultValue={null}
        name="country"
        render={({ field: { value, onChange, ref }}) => (
          <Select
            inputRef={ref}
            value={value}
            options={mapCountriesToOptions(countries)}
            onChange={(val) => onChange(val) }
          />
        )}
      />
      <Controller
        control={control}
        defaultValue={null}
        name="state"
        render={({ field: { value, onChange, ref }}) => (
          <Select
            inputRef={ref}
            value={value}
            options={mapStates(states)}
            onChange={(val) => onChange(val) }
          />
        )}
      />
      <input type="submit" value="Apply" />
      <p>{errors || ''}</p>
    </form>
  );
};
export default Filter;
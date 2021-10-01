import React, { useEffect, useState } from 'react';
import Table from 'rc-table';
import axios from 'axios';

const columns = [
  {
    title: 'ID',
    dataIndex: 'id',
    key: 'id',
    width: 10,
  },
  {
    title: 'Name',
    dataIndex: 'name',
    key: 'name',
    width: 100,
  },
  {
    title: 'Phone',
    dataIndex: 'phone',
    key: 'phone',
    width: 100,
  }
];

const tableTitle = () => <p>Customers</p>;

const List = ({ search }) => {
  const [loading, setLoading] = useState(false);
  const [customers, setCustomers] = useState([]);
  useEffect(() => {
    setLoading(true);
    axios
      .get('http://localhost:5897/customers', {
        params: {
          country: search?.country,
          state: search?.state
        }
      })
      .then(res => {
        setCustomers(res.data);
        setLoading(false);
      })
      .catch(err => {
        setLoading(false);
      });
  }, [search]);

  return loading ?
    <p>Loading...</p>
  : (
    <div style={{ maxWidth: '100%' }}>
      <Table title={tableTitle} columns={columns} data={customers} />
    </div>
  );
};
export default List;
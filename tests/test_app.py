from app.app import app


def test_index_status_code():
    client = app.test_client()
    res = client.get('/')
    assert res.status_code == 200


def test_index_content():
    client = app.test_client()
    res = client.get('/')
    assert b'CI/CD Demo App' in res.data
